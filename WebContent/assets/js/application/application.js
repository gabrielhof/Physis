$(document).ready(onDocumentReady);

/**
 * Document Related Functions
 */
function onDocumentReady() {
	$(".carousel").carousel();
	$(".back-to-top").click(backToTop);
	
	transformerNumericFields();
	transformDateFields();
	applyMasks();
	transformPrettySelect();
	
	$("input.error").change(removeErrorFieldAction);
	
	if (typeof(loadView) == "function") {
		loadView();
	}
}

function transformDateFields() {
	$("input[type='text'].date").each(function() {
		if (isStringNotBlank($(this).val())) {
			var data = $(this).val().split("-");
			if (data.length == 3) {
				$(this).val(data[2] + "/" + data[1] + "/" + data[0]);
			}
		}
		
		$(this).mask("99/99/9999");
		$(this).datepicker({language:"pt-BR", format: "dd/mm/yyyy", forceParse: false, autoclose: true});
		$(this).change(validateDate);
	});
}

function transformerNumericFields() {
	$(".numeric").numeric({negative: false, decimal: false});
	$(".decimal").numeric({negative: false, decimal: ","});
}

function applyMasks() {
	$("input[type='text'][mask]").each(function () {
		$(this).mask($(this).attr("mask"));
	});
}

function transformPrettySelect() {
	$("select").each(function () {
		var selectedOption = $(this).val();
		$(this).select2({placeholder: "Select", width: "resolve"});
		$(this).select2("val", selectedOption);
		
		$(this).change(function() {
			$(this).select2("val", $(this).val());
		});
	});
}



/**
 * Scrolling Actions
 */
function backToTop() {
	scrollTo(0);
}

function scrollTo(obj) {
	if (typeof(obj) == "object") {
		obj = obj.offset().top - 100;
	}
	
	$("html, body").animate({scrollTop: obj}, "slow");
}

/**
 * Dialogs
 */

function confirmDialog(that, message, title, doPost) {
	var target = $(that).attr("target");
	var href = $(that).attr("href");
	
	var dialogWasConfirmed = false;
	var dialogWasCanceled = false;
	
	if (message == null || typeof(message) != "string") {
		message = "Tem certeza?";
	}
	
	if (title == null || typeof(title) != "string") {
		title = message;
	}
	
	var modalDiv = $("<div class='modal hide fade'></div>");
	
	var modalHeader = $("<div class='modal-header'></div>");
	modalHeader.append($("<h3></h3>").html(title));
	
	var modalBody = $("<div class='modal-body'>");
	modalBody.append($("<p></p>").html(message));
	
	var modalFooter = $("<div class='modal-footer'></div>");
	
	var confirmDialogNoAction = function() {
		modalDiv.modal("hide");
		dialogWasCanceled = true;
	};
	
	var confirmDialogYesAction = function() {
		modalDiv.modal("hide");
		dialogWasConfirmed = true;
	};
	
	var yesDialogButton = $("<a href='javascript:void(0);' class='btn btn-primary'>Sim</a>");
	var noDialogButton = $("<a href='javascript:void(0);' class='btn'>N&atilde;o</a>");
	
	yesDialogButton.click(confirmDialogYesAction);
	noDialogButton.click(confirmDialogNoAction);
	
	modalFooter.append(yesDialogButton).append(noDialogButton);
	
	modalDiv.append(modalHeader).append(modalBody).append(modalFooter);
	$("body").append(modalDiv);
	
	var onDialogHideEvent = function () {
		modalDiv.remove();
	};
	
	var onDialogShowEvent = function() {
		yesDialogButton.focus();
	};
	
	modalDiv.on("hidden", onDialogHideEvent);
	modalDiv.on("shown", onDialogShowEvent);
	modalDiv.modal("show");
	
	var waitSomethingToHappenWithThisDialog = "";
	waitSomethingToHappenWithThisDialog = function () {
		if (!dialogWasCanceled && !dialogWasConfirmed) {
			setTimeout(waitSomethingToHappenWithThisDialog, 500);
		} else if (dialogWasConfirmed) {
			if (typeof(doPost) != "undefined" && doPost) {
				executeRequest("post", href, target);
			} else {
				if (isStringNotBlank(target)) {
					window.open(href, target);
				} else {
					window.location = href;
				}
			}
		}
	};
	
	waitSomethingToHappenWithThisDialog();
	
	return false;
}

/**
 * HTTP
 */
function executeRequest(method, url, target) {
	url = url.split("?");
	var form = $("<form class='hide'></form>");
	form.attr("method", method);
	form.attr("action", url[0]);
	
	if (isStringNotBlank(target)) {
		form.attr("target", target);
	}
	
	if (url.length > 1) {
		var parameters = url[1].split("&");
		for (var i = 0; i < parameters.length; i++) {
			var keyValue = parameters[i].split("=");
			
			var input = $("<input type='hidden' />");
			input.attr("name", keyValue[0]);
			input.attr("value", keyValue[1]);
			
			form.append(input);
		}
	}
	
	$("body").append(form);
	form.submit();
}


/**
 * Alerts
 */
function error(message) {
	alertMessage("alert-error", message);
}

function warning(message) {
	alertMessage("", message);
}

function success(message) {
	alertMessage("alert-success", message);
}

function info(message) {
	alertMessage("alert-info", message);
}

function alertMessage(type, message, timeout) {
	if (timeout == null || typeof(timeout) == "undefined") {
		timeout = 20000;
	}
	
	if (isStringBlank(message)) {
		message = "";
	}
	
	message += "<button class=\"close\" data-dismiss=\"alert\" type=\"button\">×</button>";
	
	var alertDiv = $("div.alert");
	if (alertDiv.length == 0) {
		alertDiv = $("<div class='alert hide'></div>");
		$(".content").append(alertDiv);
	}
	
	alertDiv.addClass(type);
	alertDiv.html(message);
	alertDiv.fadeIn(function() {
		scrollTo($(this));
	});
	
	if (timeout > 0) {
		setTimeout(function() {
			alertDiv.fadeOut(function() {
				$(this).attr("class", "alert hide");
				$(this).html("");
			});
		}, timeout);
	}
	
}


/**
 * Validacoes gerais
 */
function defaultFormValidation(form, validationFunction) {
	$.blockUI({message: "Por favor, aguarde..."});
	
	form = $(form);
	var result = validateRequiredFields(form) && validateEmail(form);
	
	if (result && typeof(validationFunction) == "function") {
		result = validationFunction(form);
	}
	
	$.unblockUI();
	
	return result;
}

function validateRequiredFields(form) {
	var somethingRequired = false;
	
	form.find("[required]").each(function() {
		var value = $(this).val();
		if (isStringBlank(value)) {
			somethingRequired = true;
			markField("error", $(this));
		}
	});
	
	if (somethingRequired) {
		error("<strong>Aviso!</strong> Todos os campos com * são obrigatórios.");
	}
	
	return !somethingRequired;
}

function validateEmail(form) {
	var invalidEmail = false;
	
	var emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	form.find("input[type='email']").each(function() {
		var value = $(this).val();
		if (isStringNotBlank(value)) {
			invalidEmail = !emailRegex.test(value);
			
			if (invalidEmail) {
				markField("error", $(this));
			}
		}
	});
	
	if (invalidEmail) {
		error("<strong>Aviso!</strong> Endereço de Email inválido.");
	}
	
	return !invalidEmail;
}

function validateDate(value) {
	if (isStringBlank(value)) {
		value = $(this).val();
	}

	if (typeof(value) == "string" && value.trim().length > 0) {
		var isValid = true;
		var splited = value.split("/");
		
		if (splited.length > 2) {
			for (var i = 0; i < 3; i++) {
				if (splited[i].indexOf("0") == 0) {
					splited[i] = parseInt(splited[i].substring(1, 2));
				} else {
					splited[i] = parseInt(splited[i]);
				}
			}

			var day = splited[0];
			var month = splited[1];
			var year = splited[2];
			
			if (month < 1 || month > 12) {
				isValid = false;
			} else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31) {
				isValid = false;
			} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
				isValid = false;
			}  else if (month == 2) {
				if ((year%4 == 0) && ((year%100 != 0) || (year%400 == 0))) {
					if (day > 29) {
						isValid = false;
					}
				} else if (day > 28) {
					isValid = false;
				}
			}
		} else {
			isValid = false;
		}

		if (!isValid) {
			$(this).val("");
		}
	}
}

/**
 * Validações dos campos
 */
function removeErrorFieldAction() {
	$(this).removeClass("error");
}

function markField(type, field) {
	var count = 0;
	var controlGroup = field;
	while (count < 4 && !controlGroup.hasClass("control-group")) {
		controlGroup = controlGroup.parent();
		count++;
	}
	
	controlGroup.addClass(type);
	field.change(function() {
		controlGroup.removeClass(type);
	});
}

/**
 * Metodos utilitarios
 */

function isStringBlank(s) {
	return typeof(s) != "string" || s.trim().length == 0;
}

function isStringNotBlank(s) {
	return !isStringBlank(s);
}

function resetForm(form) {
	form.find("select").each(function() {
		$(this).val("");
		$(this).change();
	});
	
	form[0].reset();
}

/**
 * Ajax
 */
function ajax(controller, action, data, method) {
	if (method == null || typeof(method) != "string") {
		type = "POST";
	}
	
	method = type.toUpperCase();
	url = appPath + "/" + controller + "/" + action;
	
	json = $.ajax({type: method, url: url, data: data, dataType: "json", async: false}).responseText;
	json = $.parseJSON(json);
	
	return json;
}

/**
 * Workaround for IE < 7
 */
if(typeof String.prototype.trim !== 'function') {
	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, '');
	};
}
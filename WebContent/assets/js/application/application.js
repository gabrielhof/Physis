$(document).ready(onDocumentReady);

/**
 * Document Related Functions
 */
function onDocumentReady() {
	$(".carousel").carousel();
	$(".back-to-top").click(backToTop);
	
	transformDateFields();
	applyMasks();
	
	$("input.error").change(removeErrorFieldAction);
}

function transformDateFields() {
	$("input[type='text'].date").each(function() {
		$(this).mask("99/99/9999");
		$(this).datepicker({language:"pt-BR", format: "dd/mm/yyyy", forceParse: false});
		$(this).change(validateDate);
	});
}

function applyMasks() {
	$("input[type='text'][mask]").each(function () {
		$(this).mask($(this).attr("mask"));
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

function confirmDialog(that, message, title) {
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
	
	modalDiv.on("hidden", onDialogHideEvent);
	modalDiv.modal("show");
	
	var waitSomethingToHappenWithThisDialog = "";
	waitSomethingToHappenWithThisDialog = function () {
		if (!dialogWasCanceled && !dialogWasConfirmed) {
			setTimeout(waitSomethingToHappenWithThisDialog, 500);
		} else if (dialogWasConfirmed) {
			window.location = href;
		}
	};
	
	waitSomethingToHappenWithThisDialog();
	
	return false;
}

/**
 * Alerts
 */
function error(message) {
	alert("alert-error", message);
}

function warning(message) {
	alert("", message);
}

function success(message) {
	alert("alert-success", message);
}

function info(message) {
	alert("alert-info", message);
}

function alert(type, message, timeout) {
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
function defaultFormValidation(form) {
	form = $(form);
	return validateRequiredFields(form) && validateEmail(form);
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
			markField("error", $(this));
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

/**
 * Workaround for IE < 7
 */
if(typeof String.prototype.trim !== 'function') {
	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, '');
	};
}
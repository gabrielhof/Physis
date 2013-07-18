$(document).ready(onDocumentReady);

/**
 * Document Related Functions
 */
function onDocumentReady() {
	$(".carousel").carousel();
	$(".back-to-top").click(backToTop);
	
	$("input[type='text'].date").datepicker({language:"pt-BR", format: "dd/mm/yyyy"});
	$("input[type='text'][mask]").each(function () {
		$(this).mask($(this).attr("mask"));
	});
	
	$("input.error").change(removeErrorFieldAction);
}

/**
 * Scrolling Actions
 */
function backToTop() {
	scrollTo(0);
}

function scrollTo(obj) {
	if (typeof(obj) == "object") {
		obj = obj.offset().top;
	}
	
	$("html, body").animate({scrollTop: obj}, "slow");
}

/**
 *
 */
function removeErrorFieldAction() {
	$(this).removeClass("error");
}

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
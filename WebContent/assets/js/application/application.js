$(document).ready(onDocumentReady);

/**
 * Document Related Functions
 */
function onDocumentReady() {
	$(".carousel").carousel();
	$(".back-to-top").click(backToTop);
	
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
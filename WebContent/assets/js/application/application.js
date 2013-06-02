$(document).ready(onDocumentReady);

function onDocumentReady() {
	$(".carousel").carousel();
	$(".back-to-top").click(backToTop);
}

function backToTop() {
	scrollTo(0);
}

function scrollTo(obj) {
	if (typeof(obj) == "object") {
		obj = obj.offset().top;
	}
	
	$("html, body").animate({scrollTop: obj}, "slow");
}
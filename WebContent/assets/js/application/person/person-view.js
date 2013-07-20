function personFormValidation(form) {
	form = $(form);
	return validatePersonEmail(form) && validateUsername(form) && validatePasswords(form);
}

function validatePersonEmail(form) {
	if (isStringNotBlank(form.find("#person\\.id").val())) {
		return true;
	}
	
	var emailField = form.find("#person\\.email");
	var isEmailValid = ajax("person", "validateEmail", {email: emailField.val()});
	
	if (!isEmailValid) {
		error("Email já em uso.");
		markField("error", emailField);
		
		return false;
	}
	
	return true;
}

function validateUsername(form) {
	if (isStringNotBlank(form.find("#person\\.id").val())) {
		return true;
	}
	
	var usernameField = form.find("#person\\.user\\.username");
	var isUsernameValid = ajax("person", "validateUsername", {username: usernameField.val()});
	
	if (!isUsernameValid) {
		error("Usuário já em uso.");
		markField("error", usernameField);
		
		return false;
	}
	
	return true;
}

function validatePasswords(form) {
	var passwordField = form.find("#person\\.user\\.password");
	var confirmationField = form.find("#passwordConfirmation");
	
	if (isStringNotBlank(passwordField.val()) && isStringNotBlank(confirmationField.val())) {
		if (passwordField.val() != confirmationField.val()) {
			error("A senha e a confirmação de senha devem ser iguais.");
			markField("error", passwordField);
			markField("error", confirmationField);
			
			return false;
		}
	}
	
	return true;
}
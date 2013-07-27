var currentRow = null;

function loadView() {
	$(".edit-training-exercise").click(editExerciseAction);
	$(".remove-training-exercise").click(removeExerciseAction);
}

function validateTrainingForm(form) {
	if (!canSave) {
		return false;
	}
	
	form = $(form);
	return hasExercises();
}

function hasExercises() {
	var trs = $("#training-exercise-table tbody tr");
	if (trs.length <= 0) {
		error("É necessário adicionar ao menos um exercício.");
		return false;
	}
	
	return true;
}

function addExerciseAction() {
	showExerciseDialog("Adicionar Exercício");
	return false;
}

function showExerciseDialog(title) {
	var dialog = $("#training-exercise");
	dialog.find("#modal-title").html(title);
	dialog.modal();
	dialog.on("hidden", onExerciseDialogHide);
}

function onExerciseDialogHide() {
	resetForm($("form#training-exercise-form"));
}

function saveExerciseAction() {
	var form = $("form#training-exercise-form");
	if (!defaultFormValidation(form[0])) {
		return;
	}
	
	var id = form.find("#id").val();
	var isEdit = currentRow != null;
	
	var trainingExercise = new Array();
	trainingExercise[0] = createTrainingExerciseProperty("exercise.id", form.find("#exercise").val(), form.find("#exercise option:selected").text());
	trainingExercise[1] = createTrainingExerciseProperty("series", form.find("#series").val());
	trainingExercise[2] = createTrainingExerciseProperty("repetitions", form.find("#repetitions").val());
	trainingExercise[3] = createTrainingExerciseProperty("weight", form.find("#weight").val());

	var tr = null;
	if (isEdit) {
		tr = currentRow;
		tr.empty();
	} else {
		tr = $("<tr class='hide'></tr>");
	}
	
	for (var i = 0; i < trainingExercise.length; i++) {
		var property = "training.trainingExercises.trainingExercise." + trainingExercise[i]["property"];
		var value = trainingExercise[i]["value"];
		var textValue = trainingExercise[i]["textValue"];
		
		var input = $("<input type='hidden' />");
		input.attr("id", property);
		input.attr("name", property);
		input.attr("value", value);
		
		var td = $("<td></td>");
		td.append(textValue);
		td.append(input);
		
		if (i == 0) {
			var idInput = $("<input type='hidden' />");
			idInput.attr("id", "training.trainingExercises.trainingExercise.id");
			idInput.attr("name", "training.trainingExercises.trainingExercise.id");
			idInput.attr("value", id);
			
			td.append(idInput);
		}
		
		tr.append(td);
	}
	
	tr.append($("<td></td>").append(createEditButton()));
	tr.append($("<td></td>").append(createtRemoveButton()));
	
	if (!isEdit) {
		var tableBody = $("#training-exercise-table tbody");
		tableBody.append(tr);
	}
	
	$("#training-exercise").modal("hide");
	tr.fadeIn();
	
	currentRow = null;
	
	return false;
}

function editExerciseAction(that) {
	if (that != null && typeof(that) == "undefined") {
		that = $(that);
	} else {
		that = $(this);
	}
	
	var tr = that.parent().parent();
	var form = $("form#training-exercise-form");
	
	form.find("#id").val(tr.find("#training\\.trainingExercises\\.trainingExercise\\.id").val());
	form.find("#exercise").val(tr.find("#training\\.trainingExercises\\.trainingExercise\\.exercise\\.id").val());
	form.find("#series").val(tr.find("#training\\.trainingExercises\\.trainingExercise\\.series").val());
	form.find("#repetitions").val(tr.find("#training\\.trainingExercises\\.trainingExercise\\.repetitions").val());
	form.find("#weight").val(tr.find("#training\\.trainingExercises\\.trainingExercise\\.weight").val());
	
	showExerciseDialog("Editar Exercício");
	
	currentRow = tr;
	
	return false;
}

function removeExerciseAction(that) {
	if (that != null && typeof(that) == "undefined") {
		that = $(that);
	} else {
		that = $(this);
	}
	
	var tr = that.parent().parent();
	tr.fadeOut(function() {
		$(this).remove();
	});
	
	return false;
}

function createTrainingExerciseProperty(property, value, textValue) {
	if (isStringBlank(textValue)) {
		textValue = value;
	}
	
	var te = new Array();
	te["property"] = property;
	te["value"] = value;
	te["textValue"] = textValue;
	
	return te;
}

function createEditButton() {
	var a = $("<a href='javascript:void(0);'></a>");
	a.append("<i class='icon-pencil'></i>");
	a.click(editExerciseAction);
	
	return a;
}

function createtRemoveButton() {
	var a = $("<a href='javascript:void(0);'></a>");
	a.append("<i class='icon-trash'></i>");
	a.click(removeExerciseAction);
	
	return a;
}
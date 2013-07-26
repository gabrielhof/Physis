<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://feevale.br/ui" prefix="f" %>

<h1><f:case when="${empty training.id}" then="Novo Treino" otherwise="Editar Treino"/></h1>

<f:form controller="training" action="save" method="post" validation="defaultFormValidation">
	<f:fieldset title="Dados Gerais">
		<f:input id="training.id" type="hidden" value="${training.id}" />
		<f:field label="Nome" type="text" id="training.name" required="true" value="${training.name}"/>
	</f:fieldset>

	<f:fieldset title="Exercícios">
		<f:button label="Adicionar Exercício" styleClass="btn btn-primary pull-right" onclick="return addExerciseAction();"/>
		
		<f:table id="training-exercise-table">
			<thead>
				<tr>
					<th>Exercício</th>
					<th>Séries</th>
					<th>Repetições</th>
					<th>Peso</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty training.trainingExercises}">
					<c:forEach var="trainingExercise" items="${training.trainingExercises}">
						<tr>
							<td>
								${trainingExercise.exercise.toUserString()}
								<f:input id="training.trainingExercise.id" type="hidden" value="${trainingExercise.id}"/>
								<f:input id="training.trainingExercise.exercise.id" type="hidden" value="${trainingExercise.exercise.id}"/>
							</td>
							<td>
								${trainingExercise.series}
								<f:input id="training.trainingExercise.series" type="hidden" value="${training.trainingExercise.series}"/>
							</td>
							<td>
								${trainingExercise.repetitions}
								<f:input id="training.trainingExercise.repetitions" type="hidden" value="${training.trainingExercise.repetitions}"/>
							</td>
							<td>
								${trainingExercise.weight}
								<f:input id="training.trainingExercise.weight" type="hidden" value="${training.trainingExercise.weight}"/>
							</td>
							<td>
								<a title="Editar" href="javascript:void(0);" onclick="return editExerciseAction(this);">
									<i class="icon-pencil"></i>
								</a>
							</td>
							<td>
								<a title="Editar" href="javascript:void(0);" onclick="return removeExerciseAction(this);">
									<i class="icon-trash"></i>
								</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</f:table>
	</f:fieldset>

	<f:buttonset>
		<f:button label="Salvar" submit="true" styleClass="btn btn-primary"/>
		<f:button label="Cancelar" controller="training" action="" onclick="return confirmDialog(this, 'Tem certeza que deseja cancelar esse registro?', 'Deseja cancelar?');" />
	</f:buttonset>
</f:form>

<div id="training-exercise" class="modal hide fade">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">x</button>
		<h3 id="modal-title"></h3>
	</div>
	<div class="modal-body">
		<form id="training-exercise-form" class="form-horizontal" onsubmit="">
			<f:input id="id" type="hidden" />
			
			<f:select-field id="exercise" label="Exercício" beans="${exercises}" styleClass="input-large" required="true"/>
				
			<f:field id="series" type="numeric" label="Séries" styleClass="input-mini" required="true"/>
			<f:field id="repetitions" type="numeric" label="Repetições" styleClass="input-mini" required="true"/>
			<f:field id="weight" type="numeric" label="Peso" styleClass="input-mini" required="true"/>
		</form>
	</div>
	<div class="modal-footer">
		<a href="javascript:void(0);" class="btn btn-primary" onclick="return saveExerciseAction();">Salvar</a>
		<button class="btn" data-dismiss="modal">Cancelar</button>
	</div>
</div>


<f:script src="application/training/training-view.js" />
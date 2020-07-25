package com.tagpedia.component.rest;

import java.util.List;

import com.google.common.base.Preconditions;


public class ResponseBuilder<E> {

	E content;
	List<String> errors;
	String message;
	Boolean success;

	ResponseBuilder() {
	}

	public Response<E> build() {
		validate();
		Response<E> r = new Response<>();
		r.setContent(content);
		r.setErrors(errors);
		r.setMessage(message);
		r.setSuccess(success);
		return r;
	}

	private void validate() {
		if (success) {
			Preconditions.checkState(message != null && !message.isEmpty(), "Erro. Uma mensagem de sucesso deve ser informada.");
			Preconditions.checkState(content != null, "Erro. O conteúdo da resposta deve ser informado.");
			Preconditions.checkState(errors == null, "Erro. Uma resposta de sucesso não pode conter erros.");
		} else {
			Preconditions.checkState(message != null && !message.isEmpty(), "Erro. Uma mensagem de erro deve ser informada.");
		}
	}

	public ResponseBuilder<E> message(String msg) {
		message = msg;
		return this;
	}

	public ResponseBuilder<E> success(boolean b) {
		success = b;
		return this;
	}

	public ResponseBuilder<E> content(E contentValue) {
		content = contentValue;
		return this;
	}

	public ResponseBuilder<E> errors(List<String> errorList) {
		errors = errorList;
		return this;
	}

}

package com.tagpedia.component.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class Response<T> {

	private Boolean success;
	private String message;
	private T content;
	private List<String> errors;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	/**
	 * @deprecated Este construtor não deve ser utilizado. Ao invés utilize
	 *             {@link ResponseBuilder#build()}
	 */
	@Deprecated
	public Response() {
	}

	public Response<T> addContent(T content) {
		this.content = content;
		return this;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Response<T> withStatus(HttpStatus httpStatus) {
		this.success = true;
		this.message = httpStatus.toString();
		return this;
	}

	public Response<T> withSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public static <E> ResponseBuilder<E> builder() {
		return new ResponseBuilder<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((success == null) ? 0 : success.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (success == null) {
			if (other.success != null)
				return false;
		} else if (!success.equals(other.success))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Response [success=" + success + ", message=" + message + ", content=" + content + ", errors=" + errors
				+ "]";
	}
	
	
}

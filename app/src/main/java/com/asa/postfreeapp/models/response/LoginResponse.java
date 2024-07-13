package com.asa.postfreeapp.models.response;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("path")
	private String path;

	@SerializedName("error")
	private String error;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponse{" + 
			"path = '" + path + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
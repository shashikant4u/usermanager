package com.tic

import grails.rest.Resource

class User {
     
	String name
	String email
	String password
	
	
    static constraints = {
		email unique:true
    }
}

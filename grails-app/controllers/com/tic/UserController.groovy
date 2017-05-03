package com.tic

import grails.rest.RestfulController

class UserController extends RestfulController {
	
	static responseFormats = ['html', 'json']
	def exportService
	
	UserController() {
		super(User)
	}
	
	/**
	 * This method is used for exporting users in csv format
	 * @return
	 */
	def export(){
		def userList = User.findAll();
		if (userList){
			List fields = ["name", "email", "password"]
			Map labels = ["name":"Name", "email":"Email", "password":"Password"]
			response.contentType = grailsApplication.config.grails.mime.types['csv']
			response.setHeader("Content-disposition", "attachment; filename=users.csv")
			exportService.export('csv', response.outputStream,userList, fields, labels, [:], [:])
			return
		}
		redirect(action:'index')
	}
	
}

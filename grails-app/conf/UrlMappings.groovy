class UrlMappings {

	static mappings = {
		
		"/users"(resources:"user",formats:['json'])
		
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}

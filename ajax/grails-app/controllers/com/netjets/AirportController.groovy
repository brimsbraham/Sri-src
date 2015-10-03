package com.netjets

class AirportController {
  def airportService
    def index() { }
	def list() {
	
	String list=airportService.list()
	render(text:list,contentType:'application/json')
    
	}
	def create() { 
	log.info "params.alternateAirport: ${params.alternateAirport},params.notes: ${params.notes}"
	String list=airportService.create(params.alternateAirport,params.notes)
	render(text:list,contentType:'application/json')
	}
	def delete() {
	String list=airportService.delete(params.id.toInteger())
	render(text:list, contentType:'application/json')
	}
	def update() {
	String list=airportService.update(params.id.toInteger(),params.alternateAirport,params.notes)
	render(text:list,contentType:'application/json')
	}
}

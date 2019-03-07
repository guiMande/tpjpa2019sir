package fr.istic.sir.rest;

import tp.Sondage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {

        String result = "Restful example : " + msg;

        return Response.status(200).entity(result).build();

    }

    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Sondage getSondage(){
        Sondage h = new Sondage("Sondage 1", "Resume 1");
        h.setId(4);

        return h;
    }
}

package captura.infra;

import captura.core.InvalidArticleObject;
import captura.application.portals.diarios.DiarioRioGrandeDoSulInitializer;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/scrapper")
@Produces(MediaType.APPLICATION_JSON)
public class ScrappersResource {

    @Inject private DiarioRioGrandeDoSulInitializer diarioRioGrandeDoSulInitializer;

    @GET
    @Path("/diario")
    @UnitOfWork(transactional = false)
    public Response run() throws IOException, InvalidArticleObject {
        this.diarioRioGrandeDoSulInitializer.init();
        return Response.ok().build();
    }
}
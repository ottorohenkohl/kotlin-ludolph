package dev.rohenkohl.domain.client

import dev.rohenkohl.domain.client.transfer.game.Game
import dev.rohenkohl.domain.client.transfer.portfolio.Portfolio
import jakarta.ws.rs.CookieParam
import jakarta.ws.rs.FormParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.QueryParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestResponse

@RegisterRestClient(baseUri = "https://investspiel.de")
interface InvestspielClient {

    @Path("/z/portfolio_assets")
    @GET
    fun getOverviewByID(
        @QueryParam("portfolio_id") id: Int
    ): RestResponse<Portfolio>

    @Path("/a/home")
    @GET
    fun getGameStatistics(
        @QueryParam("active_game_portfolio_id") id: Int,
        @CookieParam("EQSESSID") session: String
    ): RestResponse<Game>

    @Path("/a/ua/login")
    @POST
    fun postLoginByUsernamePassword(
        @FormParam("auth_email") username: String,
        @FormParam("auth_password") password: String,
        @FormParam("site") site: String
    ): RestResponse<Any>
}
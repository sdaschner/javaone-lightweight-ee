package com.sebastian_daschner.javaone;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("clouds")
public class CloudsResource {

    @Inject
    Oracle oracle;

    @Context
    UriInfo uriInfo;

    @Inject
    Event<Cloud> newClouds;

    @GET
    public JsonArray getClouds() {
        return oracle.getClouds().stream().map(this::createCloudJson).collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCloud(@NotNull @Valid final Cloud cloud) {
        oracle.createCloud(cloud);
        newClouds.fire(cloud);
    }

    @GET
    @Path("{name}")
    public JsonObject getCloud(@PathParam("name") final String name) {
        return createCloudJson(oracle.getCloud(name));
    }

    private JsonObject createCloudJson(final Cloud cloud) {
        return Json.createObjectBuilder()
                .add("name", cloud.getName())
                .add("hype", cloud.getHype())
                .add("_self", uriInfo.getBaseUriBuilder().path(CloudsResource.class).path(CloudsResource.class, "getCloud").build(cloud.getName()).toString())
                .build();
    }

}

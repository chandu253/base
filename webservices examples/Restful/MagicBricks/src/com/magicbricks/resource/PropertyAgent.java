package com.magicbricks.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

import com.magicbricks.bean.SearchCriteria;

@Path("/agent/{loc}")
public class PropertyAgent {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/locate/{pType}/{loc}")
	public String locate(@PathParam("pType") String propertyType, @PathParam("loc") String location) {
		return "<locate><pType>" + propertyType + "</pType><loc>" + location + "</loc></locate>";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/avail")
	public String getAvailableProperties(@PathParam("loc") String location) {
		return "<avail><loc>" + location + "</loc></avail>";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/nearest/{kilo}.{meters}")
	public String getNearestProperties(@PathParam("kilo") int kilometers, @PathParam("meters") int meters) {
		return "<nearest><kilo>" + kilometers + "</kilo><meters>" + meters + "</meters></nearest>";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/range")
	public String getProperties(@PathParam("loc") String location,
			@DefaultValue("50000") @QueryParam("min") double minBudget,
			@QueryParam("max") @DefaultValue("100000") double maxBudget) {
		return "<properties><loc>" + location + "</loc><min>" + minBudget + "</min><max>" + maxBudget
				+ "</max></properties>";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/search/{propertyType}/{area}")
	public String search(@PathParam("propertyType") String propertyType, @PathParam("loc") String location,
			@PathParam("area") String area, @MatrixParam("sqYards") int sqYards,
			@MatrixParam("minBudget") int minBudget, @MatrixParam("maxBudget") int maxBudget) {
		return "<search><propertyType>" + propertyType + "</propertyType><location>" + location + "</location><area>"
				+ area + "</area><sqYards>" + sqYards + "</sqYards><minBudgent>" + minBudget + "</minBudget><maxBudget>"
				+ maxBudget + "</maxBudget></search>";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/properties")
	public String getProperties(@PathParam("loc") String location, @QueryParam("amenities") List<String> amenities) {
		String response = "<properties>" + location;
		for (String amenity : amenities) {
			response += "<amenity>" + amenity + "</amenity>";
		}
		response += "</properties>";

		return response;

	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{pType}")
	public String getProperties(@PathParam("loc") PathSegment locationSegment,
			@PathParam("pType") PathSegment propertyTypeSegment) {
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		String location = locationSegment.getPath();
		MultivaluedMap<String, String> locMatrixParameters = locationSegment.getMatrixParameters();
		String pType = propertyTypeSegment.getPath();
		MultivaluedMap<String, String> propTypeMatrixParameters = propertyTypeSegment.getMatrixParameters();

		buffer.append("<request><loc>").append(location).append("</loc><matrixParameters>");
		for (String key : locMatrixParameters.keySet()) {
			List<String> values = locMatrixParameters.get(key);
			buffer.append("key :").append(key).append(" values : ");
			for (String val : values) {
				buffer.append(val).append(",");
			}
		}
		buffer.append("</matrixParameters>").append("</loc>").append("<pType>").append(pType).append("</pType>")
				.append("<matrixParameters>");
		for (String key : propTypeMatrixParameters.keySet()) {
			List<String> values = propTypeMatrixParameters.get(key);
			buffer.append("key :").append(key).append(" values : ");
			for (String val : values) {
				buffer.append(val).append(",");
			}
		}
		buffer.append("</matrixParameters>").append("</request>");

		return buffer.toString();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/add-property")
	public String addProperty(@FormParam("propertyName") String propertyName,
			@FormParam("propertyType") String propertyType, @FormParam("location") String location,
			@FormParam("facing") String facing, @FormParam("amount") float amount) {
		return "<addProperty><propertyName>" + propertyName + "</propertyName><propertyType>" + propertyType
				+ "</propertyType><location>" + location + "</location><facing>" + facing + "</facing><amount>" + amount
				+ "</amount></add-property>";
	}

	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	@Path("/unlist/{propertyNo}")
	public String unlistProperty(@PathParam("propertyNo") String propertyNo, @HeaderParam("agentNo") String agentNo) {
		return "<unlist><propertyNo>" + propertyNo + "</propertyNo><agentNo>" + agentNo + "</agentNo></unlist>";
	}

	@PUT
	@Produces(MediaType.APPLICATION_XML)
	@Path("/amenity/{amenityName}")
	public String addAmenity(@CookieParam("propertyNo") String propertyNo,
			@PathParam("amenityName") String amenityName) {
		return "<amenity><propertyNo>" + propertyNo + "</propertyNo><amentityName>" + amenityName
				+ "</amentityName></amentity>";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/find/{propertyType}")
	public String findProperties(@Context UriInfo uriInfo) {
		MultivaluedMap<String, String> queryParams = null;
		MultivaluedMap<String, String> matrixParams = null;
		List<PathSegment> pathSegments = null;
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		buffer.append("query parameters : ");
		queryParams = uriInfo.getQueryParameters();
		for (String paramName : queryParams.keySet()) {
			buffer.append(paramName).append("=").append(queryParams.getFirst(paramName)).append(";");
		}

		buffer.append("pathsegments : ");
		pathSegments = uriInfo.getPathSegments();
		for (PathSegment ps : pathSegments) {
			buffer.append(";").append(ps.getPath()).append(" matrix params : ");
			matrixParams = ps.getMatrixParameters();
			for (String paramName : matrixParams.keySet()) {
				buffer.append(paramName).append("=").append(matrixParams.getFirst(paramName)).append(";");
			}

		}
		return buffer.toString();

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/apartments/{city}")
	public String searchApartments(@BeanParam SearchCriteria searchCritera) {
		return searchCritera.toString();
	}
}













package com.mtb.cash.endpoint;

import com.bottomline.webseries.schema.external.message.imagesearch.v1.ImageSearchRequest;
import com.bottomline.webseries.schema.external.message.imagesearch.v1.ImageSearchResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;

@Endpoint
public class WebServiceEndpoint {


	private static final String NAMESPACE_URI_1 =
			"http://www.bottomline.com/webseries/schema/external/message/imagesearch/v1";

	@PayloadRoot(namespace = NAMESPACE_URI_1, localPart = "imageSearchRequest")
	@ResponsePayload
	public javax.xml.bind.JAXBElement<ImageSearchResponse> imageSearch(@RequestPayload javax.xml.bind.JAXBElement<ImageSearchRequest> request) {



		System.out.println(request.getValue().getImageType());
		com.bottomline.webseries.schema.external.message.imagesearch.v1.ObjectFactory objectFactory = new com.bottomline.webseries.schema.external.message.imagesearch.v1.ObjectFactory();
		ImageSearchResponse imageSearchResponse = objectFactory.createImageSearchResponse();
		imageSearchResponse.setImageType("RDEPITEM");

		javax.xml.bind.JAXBElement<ImageSearchResponse> jaxbElement =  new javax.xml.bind.JAXBElement(
				new QName(ImageSearchResponse.class.getSimpleName()), ImageSearchResponse.class, imageSearchResponse);
		return jaxbElement;
		}
		}

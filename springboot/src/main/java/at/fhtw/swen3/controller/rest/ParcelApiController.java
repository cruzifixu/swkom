package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.rest.ParcelApi;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-24T14:48:00.085786Z[Etc/UTC]")
@Controller
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;
    @Autowired
    private final ParcelService parcelService;

    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelService parcelService) {
        this.request = request;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    // implement the methods from the ParcelAPI

    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel){
        NewParcelInfo newParcel = parcelService.submitNewParcel(parcel);
        return new ResponseEntity<>(newParcel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TrackingInformation> trackParcel(String trackingId){
        TrackingInformation trackingInformation = null;
        // add function body
        return new ResponseEntity<>(trackingInformation, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        ResponseEntity<NewParcelInfo> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        //parcelService.transitionParcel(parcel, trackingId);
        return response;
    }

}

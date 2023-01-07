package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.rest.WarehouseApi;
import at.fhtw.swen3.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-24T14:48:00.085786Z[Etc/UTC]")
@Controller
public class WarehouseApiController implements WarehouseApi {

    private final NativeWebRequest request;

    @Autowired
    public WarehouseApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Warehouse> exportWarehouses() {
        return new ResponseEntity<Warehouse>(HttpStatus.OK);
        //return new ResponseEntity<Warehouse>(warehouseService.getWarehouse(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> importWarehouses(Warehouse warehouse) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hop> getWarehouse(String code) {
        return new ResponseEntity<Hop>(HttpStatus.OK);
        //return new ResponseEntity<Warehouse>(warehouseService.getWarehouse(), HttpStatus.OK);
    }

}

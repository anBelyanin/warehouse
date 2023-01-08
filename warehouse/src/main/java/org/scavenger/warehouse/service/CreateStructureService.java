package org.scavenger.warehouse.service;

import org.core.entities.warehouse.*;
import org.core.repositories.warehouse.*;
import org.scavenger.warehouse.common.Constants;
import org.scavenger.warehouse.common.pojo.api.requests.createstructure.*;
import org.scavenger.warehouse.common.pojo.api.responses.createstructure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("createStructureService")
public class CreateStructureService {

    private final AreasRepository areasRepository;
    private final SectionsRepository sectionsRepository;
    private final PlacesRepository placesRepository;
    private final StoredObjectsRepository storedObjectsRepository;
    private final StoredObjectsTypesRepository storedObjectsTypesRepository;

    @Autowired
    public CreateStructureService(AreasRepository areasRepository,
                                  SectionsRepository sectionsRepository,
                                  PlacesRepository placesRepository,
                                  StoredObjectsRepository storedObjectsRepository,
                                  StoredObjectsTypesRepository storedObjectsTypesRepository) {
        this.areasRepository = areasRepository;
        this.sectionsRepository = sectionsRepository;
        this.placesRepository = placesRepository;
        this.storedObjectsRepository = storedObjectsRepository;
        this.storedObjectsTypesRepository = storedObjectsTypesRepository;
    }

    public CreateAreaResponse createAreaByRequest(CreateAreaRequest request) {
        AreaEntity area = new AreaEntity();
        area.setName(request.getName());
        area.setNotes(request.getNotes());
        areasRepository.save(area);
        CreateAreaResponse response = new CreateAreaResponse();
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setName(area.getName());
        response.setNotes(area.getNotes());
        return response;
    }

    public CreateSectionResponse createSectionByRequest(CreateSectionRequest request) {
        AreaEntity area = areasRepository.findByName(request.getAreaName());
        SectionEntity section = new SectionEntity();
        section.setName(request.getName());
        section.setAreaId(area.getId());
        section.setNotes(request.getNotes());
        sectionsRepository.save(section);
        CreateSectionResponse response = new CreateSectionResponse();
        response.setAreaName(area.getName());
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setNotes(section.getNotes());
        response.setName(section.getName());
        return response;
    }

    public CreatePlaceResponse createPlaceByRequest(CreatePlaceRequest request) {
        PlaceEntity place = new PlaceEntity();
        AreaEntity area = areasRepository.findByName(request.getAreaName());
        SectionEntity section = sectionsRepository.findByNameAndAreaId(request.getSectionName(), area.getId());
        place.setSectionId(section.getId());
        place.setName(request.getName());
        place.setNotes(request.getNotes());
        placesRepository.save(place);
        CreatePlaceResponse response = new CreatePlaceResponse();
        response.setName(place.getName());
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setNotes(place.getNotes());
        response.setSectionName(section.getName());
        return response;
    }

    public CreateStoredObjectResponse createStoredObjectByRequest(CreateStoredObjectRequest request) {
        StoredObjectEntity storedObject = new StoredObjectEntity();
        AreaEntity area = areasRepository.findByName(request.getAreaName());
        SectionEntity section = sectionsRepository.findByNameAndAreaId(request.getSectionName(), area.getId());
        PlaceEntity place = section.getPlaces().stream()
                .filter(p -> p.getName().equals(request.getPlaceName()))
                .findFirst().get();
        StoredObjectTypeEntity storedObjectType = storedObjectsTypesRepository.findByTypeName(request.getTypeName());
        storedObject.setName(request.getName());
        storedObject.setReceiptDate(request.getReceiptDate());
        storedObject.setReceiptEmployeeId(1L);
        storedObject.setPlaceId(place.getId());
        storedObject.setStoredObjectType(storedObjectType);
        storedObjectsRepository.save(storedObject);
        CreateStoredObjectResponse response = new CreateStoredObjectResponse();
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setSectionName(section.getName());
        response.setName(storedObject.getName());
        response.setPlaceName(place.getName());
        response.setAreaName(area.getName());
        response.setTypeName(storedObjectType.getTypeName());
        response.setReceiptDate(storedObject.getReceiptDate());
        response.setReceiptEmployeeName(storedObject.getReceiptEmployeeId().toString());
        return response;
    }

    public CreateStoredObjectTypeResponse createStoredObjectTypeByRequest(CreateStoredObjectTypeRequest request) {
        StoredObjectTypeEntity storedObjectType = new StoredObjectTypeEntity();
        storedObjectType.setTypeName(request.getName());
        storedObjectType.setNotes(request.getNotes());
        storedObjectsTypesRepository.save(storedObjectType);
        CreateStoredObjectTypeResponse response = new CreateStoredObjectTypeResponse();
        response.setName(storedObjectType.getTypeName());
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setNotes(storedObjectType.getNotes());
        return response;
    }
}

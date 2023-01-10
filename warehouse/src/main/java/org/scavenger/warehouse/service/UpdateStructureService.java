package org.scavenger.warehouse.service;

import org.core.entities.warehouse.*;
import org.core.exceptions.BusinessException;
import org.core.repositories.warehouse.*;
import org.scavenger.warehouse.common.Constants;
import org.scavenger.warehouse.common.pojo.api.requests.updatestructure.*;
import org.scavenger.warehouse.common.pojo.api.responses.updatestructure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("updateStructureService")
public class UpdateStructureService {

    private final AreasRepository areasRepository;
    private final PlacesRepository placesRepository;
    private final SectionsRepository sectionsRepository;
    private final StoredObjectsRepository storedObjectsRepository;
    private final StoredObjectsTypesRepository storedObjectsTypesRepository;

    @Autowired
    public UpdateStructureService(AreasRepository areasRepository,
                                  PlacesRepository placesRepository,
                                  SectionsRepository sectionsRepository,
                                  StoredObjectsRepository storedObjectsRepository,
                                  StoredObjectsTypesRepository storedObjectsTypesRepository) {
        this.areasRepository = areasRepository;
        this.placesRepository = placesRepository;
        this.sectionsRepository = sectionsRepository;
        this.storedObjectsRepository = storedObjectsRepository;
        this.storedObjectsTypesRepository = storedObjectsTypesRepository;
    }

    public UpdateAreaResponse updateAreaByRequest(UpdateAreaRequest request) {
        AreaEntity area = areasRepository.findByName(request.getName());
        area.setName(request.getNewName() == null ? area.getName() : request.getNewName());
        area.setNotes(request.getNewNotes() == null ? area.getNotes() : request.getNewNotes());
        areasRepository.save(area);
        UpdateAreaResponse response = new UpdateAreaResponse();
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setNewName(area.getName());
        response.setNewNotes(area.getNotes());
        return response;
    }

    public UpdateSectionResponse updateSectionByRequest(UpdateSectionRequest request) {
        AreaEntity area = areasRepository.findByName(request.getAreaName());
        SectionEntity section = sectionsRepository.findByNameAndAreaId(request.getName(), area.getId());
        section.setName(request.getNewName() == null ? section.getName() : request.getNewName());
        section.setNotes(request.getNewNotes() == null ? section.getNotes() : request.getNewNotes());
        if (request.getNewAreaName() != null) {
            area = areasRepository.findByName(request.getNewAreaName());
            section.setAreaId(area.getId());
        }
        sectionsRepository.save(section);
        UpdateSectionResponse response = new UpdateSectionResponse();
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setNewName(section.getName());
        response.setNewNotes(section.getNotes());
        response.setNewAreaName(area.getName());
        return response;
    }

    public UpdatePlaceResponse updatePlaceByRequest(UpdatePlaceRequest request) throws BusinessException {
        AreaEntity area = areasRepository.findByName(request.getAreaName());
        SectionEntity section = sectionsRepository.findByNameAndAreaId(request.getSectionName(), area.getId());
        PlaceEntity place = placesRepository.findByNameAndSectionId(request.getName(), section.getId());
        place.setName(request.getNewName() == null ? place.getName() : request.getNewName());
        place.setNotes(request.getNewNotes() == null ? place.getNotes() : request.getNewNotes());
        if (request.getNewAreaName() != null) {
            area = areasRepository.findByName(request.getNewAreaName());
        }
        if (request.getNewSectionName() != null) {
            section = area.getSections().stream()
                    .filter(s -> s.getName().equals(request.getNewSectionName()))
                    .findFirst()
                    .orElseThrow(() -> new BusinessException("Section not found in new area"));
            place.setSectionId(section.getId());
        }
        placesRepository.save(place);
        UpdatePlaceResponse response = new UpdatePlaceResponse();
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setNewName(place.getName());
        response.setNewNotes(place.getNotes());
        response.setNewSectionName(section.getName());
        return response;
    }

    public UpdateStoredObjectResponse updateStoredObjectByRequest(UpdateStoredObjectRequest request) throws BusinessException {
        AreaEntity area = areasRepository.findByName(request.getAreaName());
        SectionEntity section = sectionsRepository.findByNameAndAreaId(request.getSectionName(), area.getId());
        PlaceEntity place = placesRepository.findByNameAndSectionId(request.getPlaceName(), section.getId());
        StoredObjectEntity storedObject = storedObjectsRepository.findByNameAndPlaceId(request.getName(), place.getId());
        storedObject.setName(request.getNewName() == null ? storedObject.getName() : request.getNewName());
        storedObject.setReceiptDate(request.getNewReceiptDate() == null ?
                storedObject.getReceiptDate() : request.getNewReceiptDate());
        storedObject.setReceiptEmployeeId(request.getNewReceiptEmployeeName() == null ?
                storedObject.getReceiptEmployeeId() : Long.valueOf(request.getNewReceiptEmployeeName()));
        if (request.getNewAreaName() != null) {
            area = areasRepository.findByName(request.getNewAreaName());
        }
        if (request.getNewSectionName() != null) {
            section = area.getSections().stream()
                    .filter(s -> s.getName().equals(request.getNewSectionName()))
                    .findFirst()
                    .orElseThrow(() -> new BusinessException("New section not found in area"));
        }
        if (request.getNewPlaceName() != null) {
            place = section.getPlaces().stream()
                    .filter(p -> p.getName().equals(request.getNewPlaceName()))
                    .findFirst()
                    .orElseThrow(() -> new BusinessException("New place not found in section"));
            storedObject.setPlaceId(place.getId());
        }
        if (request.getNewTypeName() != null) {
            StoredObjectTypeEntity type = storedObjectsTypesRepository.findByTypeName(request.getNewTypeName());
            storedObject.setStoredObjectType(type);
        }
        storedObjectsRepository.save(storedObject);
        UpdateStoredObjectResponse response = new UpdateStoredObjectResponse();
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setNewAreaName(area.getName());
        response.setNewSectionName(section.getName());
        response.setNewPlaceName(place.getName());
        response.setNewTypeName(storedObject.getStoredObjectType().getTypeName());
        response.setNewName(storedObject.getName());
        response.setNewReceiptDate(storedObject.getReceiptDate());
        response.setNewReceiptEmployeeName(storedObject.getReceiptEmployeeId().toString());
        return response;
    }

    public UpdateStoredObjectTypeResponse updateStoredObjectTypeByRequest(UpdateStoredObjectTypeRequest request) {
        StoredObjectTypeEntity type = storedObjectsTypesRepository.findByTypeName(request.getName());
        type.setTypeName(request.getNewName() == null ? type.getTypeName() : request.getNewName());
        type.setNotes(request.getNewNotes() == null ? type.getNotes() : request.getNewNotes());
        storedObjectsTypesRepository.save(type);
        UpdateStoredObjectTypeResponse response = new UpdateStoredObjectTypeResponse();
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        response.setNewName(type.getTypeName());
        response.setNewNotes(type.getNotes());
        return response;
    }
}

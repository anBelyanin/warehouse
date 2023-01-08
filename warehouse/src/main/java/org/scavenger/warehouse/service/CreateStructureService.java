package org.scavenger.warehouse.service;

import org.core.entities.warehouse.AreaEntity;
import org.core.entities.warehouse.SectionEntity;
import org.core.repositories.warehouse.*;
import org.scavenger.warehouse.common.Constants;
import org.scavenger.warehouse.common.pojo.api.requests.createstructure.CreateAreaRequest;
import org.scavenger.warehouse.common.pojo.api.requests.createstructure.CreateSectionRequest;
import org.scavenger.warehouse.common.pojo.api.responses.createstructure.CreateAreaResponse;
import org.scavenger.warehouse.common.pojo.api.responses.createstructure.CreateSectionResponse;
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
}

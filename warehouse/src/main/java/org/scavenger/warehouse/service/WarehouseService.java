package org.scavenger.warehouse.service;

import org.core.entities.warehouse.AreaEntity;
import org.core.entities.warehouse.PlaceEntity;
import org.core.entities.warehouse.StoredObjectEntity;
import org.core.entities.warehouse.StoredObjectTypeEntity;
import org.core.repositories.warehouse.AreasRepository;
import org.core.repositories.warehouse.StoredObjectsTypesRepository;
import org.scavenger.warehouse.common.Constants;
import org.scavenger.warehouse.common.pojo.api.requests.WarehouseLoadRequest;
import org.scavenger.warehouse.common.pojo.api.responses.StoredObjectsTypesResponse;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseLoadResponse;
import org.scavenger.warehouse.common.pojo.structure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("warehouseService")
public class WarehouseService {

    private final AreasRepository areasRepository;
    private final StoredObjectsTypesRepository storedObjectsTypesRepository;

    @Autowired
    public WarehouseService(AreasRepository areasRepository,
                            StoredObjectsTypesRepository storedObjectsTypesRepository) {
        this.areasRepository = areasRepository;
        this.storedObjectsTypesRepository = storedObjectsTypesRepository;
    }

    //Put validation here
    public void validateRequest(WarehouseLoadRequest warehouseRequest) {
    }

    public WarehouseLoadResponse getWarehouse() {
        List<AreaEntity> areas = areasRepository.findAll();
        WarehouseLoadResponse warehouseResponse = new WarehouseLoadResponse();
        warehouseResponse.setAreas(this.getAreasByAreasEntities(areas));
        return warehouseResponse;
    }

    public StoredObjectsTypesResponse getStoredObjectsTypes() {
        StoredObjectsTypesResponse response = new StoredObjectsTypesResponse();
        List<StoredObjectTypeEntity> storedObjectTypeEntities = storedObjectsTypesRepository.findAll();
        response.setStoredObjectsTypes(this.getStoredObjectTypesByEntities(storedObjectTypeEntities));
        response.setMessage(Constants.AUTH_SUCCESS_RESULT);
        return response;
    }

    private List<Area> getAreasByAreasEntities(List<AreaEntity> areaEntities) {
        return areaEntities.stream()
                .map(ae -> {
                    Area area = new Area();
                    area.setAreaNumber(ae.getName());
                    area.setSections(this.getSectionsByAreaEntity(ae));
                    return area;
                }).collect(Collectors.toList());
    }

    private List<Section> getSectionsByAreaEntity(AreaEntity areaEntity) {
        return areaEntity.getSections().stream()
                .map(s -> {
                    Section resultSection = new Section();
                    resultSection.setSectionNumber(s.getName());
                    resultSection.setPlaces(this.getPlacesByPlacesEntities(s.getPlaces()));
                    return resultSection;
                }).collect(Collectors.toList());
    }

    private List<Place> getPlacesByPlacesEntities(List<PlaceEntity> placeEntities) {
        return placeEntities.stream()
                .map(pe -> {
                    Place placePojo = new Place();
                    placePojo.setPlaceNumber(pe.getName());
                    placePojo.setStoredObjects(this.getStoredObjectsByStoredObjectsEntities(pe.getStoredObjects()));
                    return placePojo;
                }).collect(Collectors.toList());
    }

    private List<StoredObject> getStoredObjectsByStoredObjectsEntities(List<StoredObjectEntity> storedObjectEntities) {
        return storedObjectEntities.stream()
                .map(soe -> {
                    StoredObject storedObject = new StoredObject();
                    storedObject.setName(soe.getName());
                    storedObject.setType(soe.getStoredObjectType().getTypeName());
                    storedObject.setReceiptDate(soe.getReceiptDate());
                    storedObject.setReceivingEmployeeName(soe.getReceiptEmployeeId().toString());
                    return storedObject;
                }).collect(Collectors.toList());
    }

    private List<StoredObjectType> getStoredObjectTypesByEntities(List<StoredObjectTypeEntity> entities) {
        return entities.stream()
                .map(e -> {
                    StoredObjectType storedObjectType = new StoredObjectType();
                    storedObjectType.setTypeName(e.getTypeName());
                    storedObjectType.setNotes(e.getNotes());
                    return storedObjectType;
                }).collect(Collectors.toList());
    }

}

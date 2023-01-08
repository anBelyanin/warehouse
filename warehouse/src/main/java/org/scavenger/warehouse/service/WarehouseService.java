package org.scavenger.warehouse.service;

import org.core.entities.warehouse.AreaEntity;
import org.core.entities.warehouse.PlaceEntity;
import org.core.entities.warehouse.StoredObjectEntity;
import org.core.repositories.warehouse.AreasRepository;
import org.scavenger.warehouse.common.pojo.api.requests.WarehouseLoadRequest;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseLoadResponse;
import org.scavenger.warehouse.common.pojo.structure.Area;
import org.scavenger.warehouse.common.pojo.structure.Place;
import org.scavenger.warehouse.common.pojo.structure.Section;
import org.scavenger.warehouse.common.pojo.structure.StoredObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class WarehouseService {

    private final AreasRepository areasRepository;

    @Autowired
    public WarehouseService(AreasRepository areasRepository) {
        this.areasRepository = areasRepository;
    }

    //Put validation here
    public void validateRequest(WarehouseLoadRequest warehouseRequest) {
    }

    public WarehouseLoadResponse loadWarehouse(WarehouseLoadRequest warehouseRequest) {
        List<AreaEntity> areas = areasRepository.findAll();
        WarehouseLoadResponse warehouseResponse = new WarehouseLoadResponse();
        warehouseResponse.setAreas(this.getAreasByAreasEntities(areas));
        return warehouseResponse;
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
}

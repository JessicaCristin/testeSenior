package com.api.parkingcontrol.service;

import com.api.parkingcontrol.dtos.ItemDto;
import com.api.parkingcontrol.model.ItemModel;
import com.api.parkingcontrol.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public ItemModel create(ItemModel itemModel) {
        return itemRepository.save(itemModel);
    }

    public boolean delete(UUID id) {
        var itemId = itemRepository.findById(id);

        if (!itemId.isPresent()) {
            return false;
        }

        itemRepository.deleteById(id);
        return true;
    }

    public ItemModel read(UUID id) {
        var itemId = itemRepository.findById(id);

        if (!itemId.isPresent()) {
            return null;
        }

        return itemId.get();
    }

    public ArrayList<ItemDto> list() {
        var listItem = itemRepository.findAll();

        if (listItem.isEmpty()) {
            return null;
        }

        var listItemDto = new ArrayList<ItemDto>();

        for (ItemModel itemModel : listItem) {

            var itemDto = new ItemDto();

            itemDto.setId(itemModel.getId());
            itemDto.setOrderItens(itemModel.getOrderItens());
            itemDto.setDescription(itemModel.getDescription());
            itemDto.setValue(itemModel.getValue());
            itemDto.setType(itemModel.getType());

            listItemDto.add(itemDto);

        }
        return listItemDto;
    }



    @Transactional
    public ItemModel update(UUID id, ItemDto itemDto) {
        var item = itemRepository.findById(id).get();

        if (item == null) {
            return null;
        }

        item.setOrderItens(itemDto.getOrderItens());
        item.setDescription(itemDto.getDescription());
        item.setValue(itemDto.getValue());
        item.setType(itemDto.getType());

        return itemRepository.save(item);
    }

}



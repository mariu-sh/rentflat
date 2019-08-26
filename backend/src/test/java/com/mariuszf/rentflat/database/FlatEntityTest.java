package com.mariuszf.rentflat.database;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlatEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private FlatEntity flat;

    private RoomEntity room1;

    private RoomEntity room2;

    private FlatEntity savedFlat;

    private double flatCost = 1200.12;
    private double flatSurface = 60.25;
    private double room1Surface = 12.2;
    private double room2Surface = 13.5;

    @Before
    public void setup() {
        flat = new FlatEntity(flatCost, flatSurface);
        room1 = new RoomEntity(room1Surface, flat);
        room2 = new RoomEntity(room2Surface, flat);
        savedFlat = setupFlatWithRooms();
    }

    private FlatEntity setupFlatWithRooms() {
        entityManager.persist(flat);
        entityManager.persist(room1);
        entityManager.persist(room2);
        flat.addRoom(room1);
        flat.addRoom(room2);
        return entityManager.persistAndFlush(flat);
    }

    @Test
    public void saveFlatTest() {
        assertThat(savedFlat.getId(), is(flat.getId()));
    }

    @Test
    public void costTest() {
        assertThat(savedFlat.getCost(), is(flat.getCost()));
        assertThat(savedFlat.getCost(), is(flatCost));
    }

    @Test
    public void surfaceTest() {
        assertThat(savedFlat.getSurface(), is(flat.getSurface()));
        assertThat(savedFlat.getSurface(), is(flatSurface));
    }

    @Test
    public void roomEntityListTest() {
        assertThat(savedFlat.getRoomEntityList(), is(flat.getRoomEntityList()));
    }

    @Test
    public void roomsAmountTest(){
        assertThat(savedFlat.getRoomsAmount(), is(flat.getRoomsAmount()));
        assertThat(savedFlat.getRoomsAmount(), is(2));
    }

    @Test
    public void commonPartSurface() {
        assertThat(savedFlat.getCommonPartSurface(), is(flat.getCommonPartSurface()));
        assertThat(savedFlat.getCommonPartSurface(), is(flatSurface-(room1Surface+room2Surface)));
    }

    @Test
    public void costPerSurfaceTest() {
        assertThat(savedFlat.getCostPerSurface(), is(flat.getCostPerSurface()));
        assertThat(savedFlat.getCostPerSurface(), is(flatCost/flatSurface));
    }

    @Test
    public void commonPartCostTest() {
        double commonPartCost = (flatSurface-(room1Surface+room2Surface)) * (flatCost/flatSurface);
        assertThat(savedFlat.getCommonPartCost(), is(flat.getCommonPartCost()));
        assertThat(savedFlat.getCommonPartCost(), is(commonPartCost));
    }

    @Test
    public void commonPartCostPerRoomTest() {
        double commonPartCostPerRoom = ((flatSurface - (room1Surface + room2Surface)) * (flatCost / flatSurface)) / 2;
        assertThat(savedFlat.getCommonPartCostPerRoom(), is(flat.getCommonPartCostPerRoom()));
        assertThat(savedFlat.getCommonPartCostPerRoom(), is(commonPartCostPerRoom));
    }
}

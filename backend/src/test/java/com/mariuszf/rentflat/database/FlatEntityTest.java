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

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
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

    private double updatedFlatCost = 2512.12;
    private double updatedFlatSurface = 65.12;

    private double commonPartSurface = flatSurface - (room1Surface+room2Surface);
    private double costPerSurface = flatCost/flatSurface;
    private double commonPartCost = commonPartSurface*costPerSurface;
    private double commonPartCostPerRoom = commonPartCost/getExpectedRoomsAmount();

    private double updatedCommonPartSurface = updatedFlatSurface - (room1Surface+room2Surface);
    private double updatedCostPerSurface = updatedFlatCost/updatedFlatSurface;
    private double updatedCommonPartCost = updatedCommonPartSurface*updatedCostPerSurface;
    private double updatedCommonPartCostPerRoom = updatedCommonPartCost/getExpectedRoomsAmount();

    @Before
    public void setup() {
        flat = new FlatEntity(flatCost, flatSurface);
        room1 = new RoomEntity(room1Surface, flat);
        room2 = new RoomEntity(room2Surface, flat);
        savedFlat = getPersistedFlat();
    }

    @Test
    public void saveFlatTest() {
        assertIds();
    }

    @Test
    public void costTest() {
        assertCost(flatCost);
    }

    @Test
    public void surfaceTest() {
        assertSurface(flatSurface);
    }

    @Test
    public void roomEntityListTest() {
//        assertRoomEntityList(getExpectedRoomEntityList());
    }

    @Test
    public void roomsAmountTest(){
        assertRoomsAmount(getExpectedRoomsAmount());
    }

    @Test
    public void commonPartSurface() {
        assertCommonPartSurface(commonPartSurface);
    }

    @Test
    public void costPerSurfaceTest() {
        assertCostPerSurface(costPerSurface);
    }

    @Test
    public void commonPartCostTest() {
        assertCommonPartCost(commonPartCost);
    }

    @Test
    public void commonPartCostPerRoomTest() {
        assertCommonPartCostPerRoom(commonPartCostPerRoom);
    }

    @Test
    public void updateFlatTest() {
        savedFlat = getUpdatedFlat();
        assertIds();
    }

    @Test
    public void updatedCostTest() {
        savedFlat = getUpdatedFlat();
        assertCost(updatedFlatCost);
    }

    @Test
    public void updatedSurfaceTest() {
        savedFlat = getUpdatedFlat();
        assertSurface(updatedFlatSurface);
    }

    @Test
    public void updatedRoomEntityListTest() {
//        savedFlat = getUpdatedFlat();
//        assertRoomEntityList(getExpectedRoomEntityList());
    }

    @Test
    public void updatedRoomsAmountTest(){
        savedFlat = getUpdatedFlat();
        assertRoomsAmount(getExpectedRoomsAmount());
    }

    @Test
    public void updatedCommonPartSurface() {
        savedFlat = getUpdatedFlat();
        assertCommonPartSurface(updatedCommonPartSurface);
    }

    @Test
    public void updatedCostPerSurfaceTest() {
        savedFlat = getUpdatedFlat();
        assertCostPerSurface(updatedCostPerSurface);
    }

    @Test
    public void updatedCommonPartCostTest() {
        savedFlat = getUpdatedFlat();
        assertCommonPartCost(updatedCommonPartCost);
    }

    @Test
    public void updatedCommonPartCostPerRoomTest() {
        savedFlat = getUpdatedFlat();
        assertCommonPartCostPerRoom(updatedCommonPartCostPerRoom);
    }

    private void assertIds(){
        assertThat(savedFlat.getId(), is(flat.getId()));
    }

    private void assertCost(double expectedCost){
        assertThat(savedFlat.getCost(), is(flat.getCost()));
        assertThat(savedFlat.getCost(), is(expectedCost));
    }

    private void assertSurface(double expectedSurface) {
        assertThat(savedFlat.getSurface(), is(flat.getSurface()));
        assertThat(savedFlat.getSurface(), is(expectedSurface));
    }

    private void assertRoomEntityList(List<RoomEntity> expectedRoomEntityList) {
        assertThat(savedFlat.getRoomEntityList(), is(flat.getRoomEntityList()));
        assertThat(savedFlat.getRoomEntityList(), is(expectedRoomEntityList));
    }

    private void assertRoomsAmount(int expectedRoomsAmount) {
        assertThat(savedFlat.getRoomsAmount(), is(flat.getRoomsAmount()));
        assertThat(savedFlat.getRoomsAmount(), is(expectedRoomsAmount));
    }

    private void assertCommonPartSurface(double expectedCommonPartSurface) {
        assertThat(savedFlat.getCommonPartSurface(), is(flat.getCommonPartSurface()));
        assertThat(savedFlat.getCommonPartSurface(), is(expectedCommonPartSurface));
    }

    private void assertCostPerSurface(double expectedCostPerSurface) {
        assertThat(savedFlat.getCostPerSurface(), is(flat.getCostPerSurface()));
        assertThat(savedFlat.getCostPerSurface(), is(expectedCostPerSurface));
    }

    private void assertCommonPartCost(double expectedCommonPartCost) {
        assertThat(savedFlat.getCommonPartCost(), is(flat.getCommonPartCost()));
        assertThat(savedFlat.getCommonPartCost(), is(expectedCommonPartCost));
    }

    private void assertCommonPartCostPerRoom(double expectedCommonPartCostPerRoom) {
        assertThat(savedFlat.getCommonPartCostPerRoom(), is(flat.getCommonPartCostPerRoom()));
        assertThat(savedFlat.getCommonPartCostPerRoom(), is(expectedCommonPartCostPerRoom));
    }

    private int getExpectedRoomsAmount() {
        return getExpectedRoomEntityList().size();
    }

    private List<RoomEntity> getExpectedRoomEntityList() {
        return Arrays.asList(room1, room2);
    }

    private FlatEntity getPersistedFlat() {
        entityManager.persist(flat);
        entityManager.persist(room1);
        entityManager.persist(room2);
        flat.addRoom(room1);
        flat.addRoom(room2);
        return entityManager.persistAndFlush(flat);
    }

    private FlatEntity getUpdatedFlat() {
        flat.update(updatedFlatCost, updatedFlatSurface);
        return entityManager.persistFlushFind(flat);
    }
}

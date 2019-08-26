package com.mariuszf.rentflat.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mariuszf.rentflat.buisness.FlatRoomService;
import com.mariuszf.rentflat.web.dto.*;
import com.mariuszf.rentflat.web.exception.FlatNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(MockitoJUnitRunner.class)
public class FlatControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper mapper;

    @Mock
    private FlatRoomService flatRoomService;

    @InjectMocks
    private FlatController flatController;

    @Before
    public void setup() {
        mapper = new ObjectMapper();

        mockMvc = MockMvcBuilders.standaloneSetup(flatController).build();
    }

    @Test
    public void createFlatTest() throws Exception {

        double cost = 132.23;
        double surface = 300.12;

//        FlatDTO flatDTO = new FlatDTO(123L, cost, surface, surface, new ArrayList<>());

        String jsonCreateFlat = String.format(
                "{\"cost\": %s, \"surface\": %s}",
                Double.toString(cost),
                Double.toString(surface));

        FlatCreateDTO flatCreateDTO = mapper.readValue(jsonCreateFlat, FlatCreateDTO.class);

//        given(flatRoomService.createFlat(flatCreateDTO)).willReturn(flatDTO);

        MockHttpServletResponse response = mockMvc.perform(
                post("/flat").contentType(MediaType.APPLICATION_JSON).content(jsonCreateFlat))
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.CREATED.value()));
//        TODO: Get to know WhyTF this is actually geting empty body???
//        assertThat(response.getContentAsString(), is(mapper.writeValueAsString(flatDTO)));

    }

    @Test
    public void getFlatsTest() throws Exception {

        List<FlatDTO> flats = new ArrayList<>();
        flats.add(new FlatDTO(1L, 3000, 123.23, 3000, new ArrayList<>()));
        flats.add(new FlatDTO(2L, 40000, 200.50, 180, new ArrayList<>()));

        given(flatRoomService.getFlats()).willReturn(flats);

        MockHttpServletResponse response = mockMvc.perform(
                get("/flat")
        ).andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), is(mapper.writeValueAsString(flats)));
    }

    @Test
    public void getFlatByIdTest() throws Exception {

        // setup variables
        long flatId = 1L;
        double flatCost = 3000;
        double flatSurface = 3000;

        RoomDTO room1 = new RoomDTO(1L, 12.25);
        RoomDTO room2 = new RoomDTO(2L, 15.25);

        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        double commonPartSurface = flatSurface - room1.getSurface() - room2.getSurface();

        FlatDTO flat = new FlatDTO(flatId, flatCost, flatSurface, commonPartSurface, rooms);

        given(flatRoomService.getFlatById(flatId)).willReturn(flat);

        MockHttpServletResponse response = mockMvc.perform(get("/flat/" + flatId))
                .andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), is(mapper.writeValueAsString(flat)));
    }

    @Test
    public void getFlatWithNoFlatTest() throws Exception {
        long id = 2L;

        given(flatRoomService.getFlatById(id)).willThrow(new FlatNotFoundException());

        MockHttpServletResponse response = mockMvc.perform(
                get("/flat/" + id)
        ).andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    public void updateFlatByIdTest() throws Exception {

        long id = 1235L;
        double cost = 132.23;
        double surface = 300.12;

//        FlatDTO flatDTO = new FlatDTO(id, cost, surface, surface, new ArrayList<>());

        String jsonUpdateFlat = String.format(
                "{\"cost\": %s, \"surface\": %s}",
                Double.toString(cost),
                Double.toString(surface));

//        given(flatRoomService.updateFlatById(
//                id,
//                mapper.readValue(jsonUpdateFlat, FlatUpdateDTO.class))
//              ).willReturn(flatDTO);

        MockHttpServletResponse response = mockMvc.perform(
                put("/flat/" + id).content(jsonUpdateFlat).contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
//        assertThat(response.getContentAsString(), is(mapper.writeValueAsString(flatDTO)));
    }

    @Test
    public void deleteFlatByIdTest() throws Exception {
        long id = 123L;

        MockHttpServletResponse response = mockMvc.perform(
                delete("/flat/" + id)
        ).andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    @Test
    public void getFlatsCostTest() throws Exception {

        List<FlatCostDTO> flatCostDTOList = new ArrayList<>();
        flatCostDTOList.add(new FlatCostDTO(1L, 3000, new ArrayList<>()));

        List<RoomCostDTO> roomCostDTOList = new ArrayList<>();
        roomCostDTOList.add(new RoomCostDTO(1L, 1500.33));
        roomCostDTOList.add(new RoomCostDTO(2L, 1200.25));

        flatCostDTOList.add(new FlatCostDTO(2L, 2700.58, roomCostDTOList));

        given(flatRoomService.getFlatsCost()).willReturn(flatCostDTOList);

        MockHttpServletResponse response = mockMvc.perform(
                get("/flat/cost")
        ).andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), is(mapper.writeValueAsString(flatCostDTOList)));
    }

    @Test
    public void getFlatCostByIdTest() throws Exception {
        Long id = 122352336L;

        FlatCostDTO flatCostDTO = new FlatCostDTO(1L, 31251.12, new ArrayList<>());

        given(flatRoomService.getFlatCostById(id)).willReturn(flatCostDTO);

        MockHttpServletResponse response = mockMvc.perform(
                get("/flat/" + id + "/cost")
        ).andReturn().getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), is(mapper.writeValueAsString(flatCostDTO)));

    }
}

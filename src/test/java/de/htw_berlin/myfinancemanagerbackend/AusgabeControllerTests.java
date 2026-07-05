package de.htw_berlin.myfinancemanagerbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AusgabeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void ausgabeErstellenUndAbrufen() throws Exception {
        String neueAusgabe = """
                {"titel":"Testeinkauf","betrag":42.5,"kategorie":"Lebensmittel","datum":"2026-07-05"}
                """;

        mockMvc.perform(post("/ausgaben")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(neueAusgabe))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titel").value("Testeinkauf"));

        mockMvc.perform(get("/ausgaben"))
                .andExpect(status().isOk());
    }

    @Test
    void loeschenNichtExistierenderAusgabeGibt404() throws Exception {
        mockMvc.perform(delete("/ausgaben/999999"))
                .andExpect(status().isNotFound());
    }
}

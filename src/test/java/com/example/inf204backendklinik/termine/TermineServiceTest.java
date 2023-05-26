package com.example.inf204backendklinik.termine;

import com.example.inf204backendklinik.doktor.Doktor;
import com.example.inf204backendklinik.patient.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


// we can delete all mockito annotations and just add the @ExtendWith(MockitoExtension.class)

class TermineServiceTest {

    @Mock
    private TermineRepository termineRepository;
    private TermineService underTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TermineService(termineRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
       autoCloseable.close();
    }
    @Test
    void canGetTermine() {
        //when
        underTest.getTermine();
        //then
        Mockito.verify(termineRepository).findAll();
    }

    @Test
    void canErstellNeuenTermin() {
        //given
        Patient patient = new Patient(397222222222L);
        Doktor doktor = new Doktor(1L);
        LocalDateTime now = LocalDateTime.now();
        Termine termin = new Termine(now, "9.40");
        // when
        underTest.erstellNeuenTermin(termin);
        //then
        ArgumentCaptor<Termine> termineArgumentCaptor = ArgumentCaptor.forClass(Termine.class);
        Mockito.verify(termineRepository).save(termineArgumentCaptor.capture());
        Termine capturedTermin = termineArgumentCaptor.getValue();
        assertThat(capturedTermin).isEqualTo(termin);
    }

    @Test
    void willThrowExceptionWhenDatumExists() {
        //given
        Patient patient = new Patient(397222222222L);
        Doktor doktor = new Doktor(1L);
        LocalDateTime now = LocalDateTime.now();
        Termine termin = new Termine(now, "9.40");
        given(termineRepository.existsTerminByDatum(termin.getTerminDatum())).willReturn(true);
        // when
        //then
        assertThatThrownBy(() -> underTest.erstellNeuenTermin(termin))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Dieser Termin ist schon genommen! Bitte wählen sie einen neuen Termin aus");
        verify(termineRepository, never()).save(any());
    }


}
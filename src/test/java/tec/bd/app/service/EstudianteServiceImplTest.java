package tec.bd.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tec.bd.app.dao.EstudianteDAO;
import tec.bd.app.domain.Estudiante;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceImplTest {

    @Mock
    private EstudianteDAO estudianteDAO;

    @InjectMocks
    private EstudianteServiceImpl estudianteService;


    @BeforeEach
    public void setUp() throws Exception {

    }



}

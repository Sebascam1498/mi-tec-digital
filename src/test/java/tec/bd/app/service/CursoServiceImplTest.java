package tec.bd.app.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tec.bd.app.dao.CursoDAO;
import tec.bd.app.domain.Curso;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class CursoServiceImplTest {

    @Mock
    CursoDAO cursoDAO;

    @InjectMocks
    CursoServiceImpl cursoService;




}

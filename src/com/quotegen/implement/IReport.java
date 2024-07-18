package com.quotegen.implement;

import com.quotegen.domain.*;
import java.util.ArrayList;

public interface IReport {
    
    
    void generateReport(Reporte reporte , ArrayList<Producto> dataProducto, String pathReporte);
}

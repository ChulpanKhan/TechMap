
package com.mycompany.techmap.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mycompany.techmap.model.Product;
import java.io.File;
import java.io.IOException;

public class JsonService {
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void saveProductToFile(Product product, File file) throws IOException {
        mapper.writeValue(file, product);
    }

    public static Product loadProductFromFile(File file) throws IOException {
        return mapper.readValue(file, Product.class);
    }
}

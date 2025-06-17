
package com.mycompany.techmap.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mycompany.techmap.model.Product;
import java.io.File;
import java.io.IOException;
/**
 * Утилитный класс для сериализации и десериализации продуктов в/из JSON-файлов.
 */
public class JsonService {
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    
    /**
     * Сохраняет продукт в JSON-файл.
     * @param product изделие
     * @param file файл
     */
    public static void saveProductToFile(Product product, File file) throws IOException {
        mapper.writeValue(file, product);
    }

    /**
     * Загружает продукт из JSON-файла.
     * @param file файл
     * @return загруженный продукт
     */
    public static Product loadProductFromFile(File file) throws IOException {
        return mapper.readValue(file, Product.class);
    }
}

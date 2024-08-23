package ecommerce.product.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.product.dto.ProductDto;
import ecommerce.product.dto.ProductRequestDto;
import ecommerce.product.exception.ProductException;
import ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/filter")
    public ResponseEntity<Page<ProductDto>> findProductByCategoryHandler(@RequestParam String categoryId,
            @RequestParam List<String> colors, @RequestParam List<String> sizes, @RequestParam Double minPrice,
            @RequestParam Double maxPrice, @RequestParam Integer minDiscount, @RequestParam String sort,
            @RequestParam Boolean isInStock, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {

        Page<ProductDto> res = productService.filter(
                categoryId,
                colors,
                sizes,
                minPrice,
                maxPrice,
                minDiscount,
                sort,
                isInStock,
                pageNumber,
                pageSize);

        return new ResponseEntity<Page<ProductDto>>(res, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> products = productService.getAll();
        return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable String id) throws ProductException {
        ProductDto product = productService.findById(id);
        return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> search(@RequestParam String q) {
        List<ProductDto> products = productService.search(q);
        return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductRequestDto dto) throws ProductException {
        var product = productService.create(dto);
        return new ResponseEntity<ProductDto>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable String id, @RequestBody ProductRequestDto dto) throws ProductException {
        ProductDto product = productService.update(id, dto);
        return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws ProductException {
        String res = productService.delete(id);
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }
}

package com.example.ss11.repository;

import com.example.ss11.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepo implements IBookRepo {
    private static Map<Integer, Book> bookMap;

    static {
        bookMap = new HashMap<>();
        bookMap.put(1, new Book(1, "Nhà Giả Kim", 500, "Paulo Coelho", "Tiểu thuyết"));
        bookMap.put(2, new Book(2, "Đắc Nhân Tâm", 330, "Dale Carnegie", "Self-help"));
        bookMap.put(3, new Book(3, "Cách nghĩ để thành công", 400, "Napoleon Hill", "Triết lý"));
        bookMap.put(4, new Book(4, "Hạt giống tâm hồn", 230, "Nhiều tác giả", "Câu chuyện"));
        bookMap.put(5, new Book(5, " Quẳng gánh lo đi và vui sống", 150, "Dale Carnegie", "Phân tích & giải đáp"));
        bookMap.put(6, new Book(6, "Đọc Vị Bất Kỳ Ai ", 760, "David J.Lieberman", "Cẩm nang"));
        bookMap.put(7, new Book(7, "Tiểu thuyết Bố Già", 135, "Mario Puzo", "Câu chuyện"));
        bookMap.put(8, new Book(8, "Cuộc sống không giới hạn", 762, "Nick Vujicic", "Câu chuyện"));
        bookMap.put(9, new Book(9, "Đời Thay Đổi Khi Chúng Ta Thay Đổi", 463, "Andrew Matthews", "Triết lý"));
        bookMap.put(10, new Book(10, "Người giàu có nhất thành Babylon", 551, "George Samuel Clason", "Nguyên lý"));
        bookMap.put(11, new Book(11, "7 Thói Quen Để Thành Đạt", 220, "Stephen R. Covey", "Cẩm nang"));
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public void add(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public void edit(int id, Book book) {
        bookMap.put(id, book);
    }

    @Override
    public void delete(int id) {
        bookMap.remove(id);
    }

    @Override
    public Book findById(int id) {
        return bookMap.get(id);
    }
}

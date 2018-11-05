package controller.service;

import model.Books;

public abstract class AbsService {
    protected Books model;

    public void setModel(Books model) {
        this.model = model;
    }

    public Books getModel() {
        return model;
    }
}

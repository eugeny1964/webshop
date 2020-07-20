package com.evgueny.webshop.exception;

import org.sonatype.aether.RepositoryException;

public class ConstraintViolationExeption extends RepositoryException {

    public ConstraintViolationExeption(String message) {
        super(message);
    }
}

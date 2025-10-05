package com.dailyhaul.product.exception;

public record ErrorResponse(int status, String message, String path) {
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.payroll;

/**
 *
 * @author ramos
 */

class OrderNotFoundException extends RuntimeException {

  OrderNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}

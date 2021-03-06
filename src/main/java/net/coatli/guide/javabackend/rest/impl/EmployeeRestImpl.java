package net.coatli.guide.javabackend.rest.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.coatli.guide.javabackend.core.service.EmployeeService;
import net.coatli.guide.javabackend.events.employee.CreateEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.DeleteEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeCreatedEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeDeletedEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeUpdatedEvent;
import net.coatli.guide.javabackend.events.employee.RequestAllEmployeesEvent;
import net.coatli.guide.javabackend.events.employee.RequestEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.ResponseAllEmployeesEvent;
import net.coatli.guide.javabackend.events.employee.ResponseEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.UpdateEmployeeEvent;
import net.coatli.guide.javabackend.rest.EmployeeRest;

/**
 * Implementation for the REST {@link EmployeeRest}.
 */
@Component
public class EmployeeRestImpl implements EmployeeRest {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestImpl.class);

  @Autowired
  private EmployeeService employeeService;

  /**
   * {@inheritDoc}
   */
  @Override
  public EmployeeCreatedEvent createEmployee(final CreateEmployeeEvent createEmployeeEvent) {

    return employeeService.createEmployee(createEmployeeEvent);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseEmployeeEvent requestEmployee(final RequestEmployeeEvent requestEmployeeEvent) {

    return employeeService.requestEmployee(requestEmployeeEvent);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public EmployeeUpdatedEvent updateEmployee(final UpdateEmployeeEvent updateEmployeeEvent) {

    return employeeService.updateEmployee(updateEmployeeEvent);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public EmployeeDeletedEvent deleteEmployee(final DeleteEmployeeEvent deleteEmployeeEvent) {

    return employeeService.deleteEmployee(deleteEmployeeEvent);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ResponseAllEmployeesEvent requestAllEmployees(
      final RequestAllEmployeesEvent requestAllEmployeesEvent) {

    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("requestAllEmployees input: {}", requestAllEmployeesEvent);
    }

    return employeeService.requestAllEmployees(requestAllEmployeesEvent);
  }

}

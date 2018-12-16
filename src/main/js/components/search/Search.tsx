import * as React from "react";
import {Button, Col, Form, FormGroup, Input, Label, Row} from "reactstrap";

export class Search extends React.Component {

  render() {
    return (
      <Row>
        <Col md={12}>
          <h4>Buscador</h4>
          <Form>
            <Row>
              <Col md={3}>
                <FormGroup>
                  <Label for="nce">Nº CE</Label>
                  <Input type="text" name="nce" id="nce" placeholder="Buscar por Nº CE"/>
                </FormGroup>
                <Button color="primary" size="sm">Buscar por Nº CE</Button>
              </Col>
              <Col md={3}>
                <FormGroup>
                  <Label for="name">CAS</Label>
                  <Input type="text" name="cas" id="cas" placeholder="Buscar por CAS"/>
                </FormGroup>
                <Button color="primary" size="sm">Buscar por CAS</Button>
              </Col>
              <Col md={6}>
                <FormGroup>
                  <Label for="name">Nombre</Label>
                  <Input type="text" name="name" id="name" placeholder="Buscar por Nombre"/>
                </FormGroup>
                <Button color="primary" size="sm">Buscar por Nombre</Button>
              </Col>
            </Row>
          </Form>
        </Col>
      </Row>
    );
  }

}
import * as React from "react";
import {Button, Col, Form, FormGroup, Input, Label, Row} from "reactstrap";

export class Search extends React.Component<any, any> {

  constructor(props: any) {
    super(props);

    this.state = {
      nce: undefined,
      cas: undefined,
      name: undefined
    }
  }

  public handleSearchCompoundBy(criteria: string): void {
    fetch('/api/compounds/find?' + criteria, {credentials: 'same-origin',})
      .then((response) => {
        return response.json();
      })
      .then((results) => {
        this.props.onChange(results);
      })
      .catch((e) => {
        return e;
      });
  }

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
                  <Input type="text" name="nce" id="nce" placeholder="Buscar por Nº CE"
                         onChange={(e: any) => this.handleChange(e)}/>
                </FormGroup>
                <Button color="primary" size="sm"
                        onClick={() => this.handleSearchCompoundBy('nce=' + this.state.nce)}>Buscar por Nº CE</Button>
              </Col>
              <Col md={3}>
                <FormGroup>
                  <Label for="name">CAS</Label>
                  <Input type="text" name="cas" id="cas" placeholder="Buscar por CAS"
                         onChange={(e: any) => this.handleChange(e)}/>
                </FormGroup>
                <Button color="primary" size="sm"
                        onClick={() => this.handleSearchCompoundBy('cas=' + this.state.cas)}>Buscar por CAS</Button>
              </Col>
              <Col md={6}>
                <FormGroup>
                  <Label for="name">Nombre</Label>
                  <Input type="text" name="name" id="name" placeholder="Buscar por Nombre"
                         onChange={(e: any) => this.handleChange(e)}/>
                </FormGroup>
                <Button color="primary" size="sm"
                        onClick={() => this.handleSearchCompoundBy('name=' + this.state.name)}>Buscar por Nombre</Button>
              </Col>
            </Row>
          </Form>
        </Col>
      </Row>
    );
  }

  private handleChange(event: any) {
    const target = event.target;
    const value = (target.type === 'checkbox' || target.type === 'radio') ? target.checked : target.value;
    const name = target.name;

    this.cleanSearchFields();

    this.setState({
      [name]: value
    });
  }

  private cleanSearchFields() {
    this.setState({
      nce: undefined,
      cas: undefined,
      name: undefined
    });
  }

}
import * as React from "react";
import {Button, Col, Form, FormGroup, Input, Label, Row, Spinner} from "reactstrap";

export class Search extends React.Component<any, any> {

  constructor(props: any) {
    super(props);

    this.state = {
      nce: '',
      ncas: '',
      name: '',
      searching: false
    }
  }

  public handleSearchCompoundBy(criteria: string): void {
    this.setState({searching: true});

    fetch('/api/compounds/find?' + criteria, {credentials: 'same-origin',})
      .then((response) => {
        return response.json();
      })
      .then((results) => {
        this.setState({searching: false});
        this.props.onChange(results);
      })
      .catch((e) => {
        return e;
      });
  }

  render() {

    const spinner = this.state.searching ? <Spinner size="sm" color="light"/> : '';

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
                         value={this.state.nce}
                         onChange={(e: any) => this.handleChange(e)}/>
                </FormGroup>
              </Col>
              <Col md={3}>
                <FormGroup>
                  <Label for="name">CAS</Label>
                  <Input type="text" name="cas" id="cas" placeholder="Buscar por CAS"
                         value={this.state.ncas}
                         onChange={(e: any) => this.handleChange(e)}/>
                </FormGroup>
              </Col>
              <Col md={6}>
                <FormGroup>
                  <Label for="name">Nombre</Label>
                  <Input type="text" name="name" id="name" placeholder="Buscar por Nombre"
                         value={this.state.name}
                         onChange={(e: any) => this.handleChange(e)}/>
                </FormGroup>
              </Col>
            </Row>
            <Row>
              <Col md={2}>
                <Button color="primary" size="sm"
                        onClick={() => this.handleSearchCompoundBy(
                          'nce=' + this.state.nce +
                          '&ncas=' + this.state.ncas +
                          '&name=' + this.state.name)}>{spinner} Buscar Compuesto
                </Button>
              </Col>
              <Col md={2}>
                <Button color={"danger"} size={"sm"}
                        onClick={() => this.cleanSearchFields()}> Limpiar Formulario</Button>
              </Col>
            </Row>
          </Form>
        </Col>
      </Row>
    )
      ;
  }

  private handleChange(event: any) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  // TODO: clean form fields
  private cleanSearchFields() {
    this.setState({
      nce: '',
      ncas: '',
      name: ''
    });
  }

}
import * as React from "react";
import {Button, Col, Form, Input, Row, Table} from "reactstrap";


export class CompoundsForm extends React.Component<any, any> {

  constructor(props: any) {
    super(props);

    this.state = {
        compounds: []
    };
  }

  public render() {
    let compounds = this.props.selection.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.cas}</td>
          <td>{compound.name}</td>
          <td>
            <Input type="text" name="concentration" id="concentration" placeholder="Concentración"
                   data-compound={compound.name}
                   onChange={(event: any) => {this.handleChange(event)}}/>
          </td>
          <td>
            <Input type="text" name="exposition" id="exposition" placeholder="Exposición"
                   data-compound={compound.name}
                   onChange={(event: any) => {this.handleChange(event)}}/>
          </td>
          <td>
            <Button color="danger" size="sm" onClick={() => {this.removeFromSelected(index)}}>Eliminar</Button>
          </td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Compuestos</h4>
          <Form>
            <Table>
              <thead>
              <tr>
                <th>#</th>
                <th>CAS</th>
                <th>Nombre</th>
                <th>Concetración</th>
                <th>Tiempo</th>
                <th/>
              </tr>
              </thead>
              <tbody>{compounds}</tbody>
            </Table>
            <Button color="success" onClick={(e: any) => {this.handleSubmit(e)}}>Generar informe</Button>
          </Form>
        </Col>
      </Row>
    );
  }

  private removeFromSelected(index: number) {
    this.props.onChange(index);
  }

  private handleSubmit(e: any) {
    e.preventDefault();

    fetch('/api/edit', {
      method: 'POST',
      credentials: 'same-origin',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(this.state)
    })
        .then((response) => {
          return response.json();
        })
        .then((savedSimulation) => {
          this.props.history.push('/simulation/' + savedSimulation.id);
        })
        .catch((e) => {
          return e;
        })
  }

  private handleChange(e: any) {
    const target = e.target;

    const value = target.value;
    const compoundId = target.dataset.compound;
    const name = target.name;

    const compounds = this.state.compounds.slice();
    let compound = compounds.find((c: any) => c.compound === compoundId);

    if (compound) {
        compound[name] = value;
    } else {
        compounds.push({
            compound: compoundId,
            [name]: value
        });
    }

    this.setState({compounds: compounds});
  }

}
import * as React from "react";
import {Button, Col, Form, Input, Row, Spinner, Table} from "reactstrap";


export class CompoundsForm extends React.Component<any, any> {

  constructor(props: any) {
    super(props);

    this.state = {
      compounds: [],
      generatingReport: false
    };
  }

  public render() {
    const spinner = this.state.generatingReport && <Spinner size="sm" color="light"/>;

    let compounds = this.props.selection.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.ncas}</td>
          <td><a href={compound.url} target={"_blank"}>{compound.name}</a></td>
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
            <Button color="success" disabled={this.state.generatingReport}
                    onClick={(e: any) => {
                      this.handleSubmit(e)
                    }}>{spinner} Generar informe</Button>
          </Form>
        </Col>
      </Row>
    );
  }

  private removeFromSelected(index: number) {
    const results = this.state.compounds.slice();

    results.splice(this.state.compounds[index], 1);
    this.setState({compounds: results});

    this.props.onChange(index);
  }

  private handleSubmit(e: any) {
    e.preventDefault();
    this.setState({generatingReport: true});

    fetch('/api/reports/create', {
      method: 'POST',
      credentials: 'same-origin',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({"compounds": this.state.compounds})
    })
      .then((response) => {
          return response.json();
        })
      .then((report) => {
        this.setState({generatingReport: false});
        this.props.onUpdate(report);
        })
        .catch((e) => {
          return e;
        })
  }

  private handleChange(e: any) {
    const target = e.target;

    const value = target.value;
    const name = target.dataset.compound;
    const param = target.name;

    const compounds = this.state.compounds.slice();
    let compound = compounds.find((c: any) => c.name === name);

    if (compound) {
      compound[param] = value;
    } else {
        compounds.push({
          name: name,
          [param]: value
        });
    }

    this.setState({compounds: compounds});
  }

}
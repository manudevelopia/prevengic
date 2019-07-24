import * as React from "react";
import {Col, Row, Table} from "reactstrap";


export class NotesAndAdvices extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }

  public render() {
    let compounds = this.props.results.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.name}</td>
          <td>{this.extractCodes(compound.warningAdvices)}</td>
          <td>{this.extractCodes(compound.notes)}</td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Resumen Frases H y Notas</h4>
          <Table>
            <thead>
            <tr>
              <th>#</th>
              <th>Nombre</th>
              <th>FH</th>
              <th>Notes</th>
            </tr>
            </thead>
            <tbody>{compounds}</tbody>
          </Table>
        </Col>
      </Row>
    );
  }

  private extractCodes(c: any): string{
    let codes: any = [];
    c.forEach((c: any) => {
      codes.push(c.code);
    });

    return codes.join(', ');
  }

}
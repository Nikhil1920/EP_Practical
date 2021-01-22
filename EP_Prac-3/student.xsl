<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Student's List</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>ID</th>
                        <th>Reg. No</th>
                        <th>Name</th>
                        <th>Average</th>
                        <th>DOB</th>
                        <th>Mobile Number</th>
                        <th>Distinction</th>
                    </tr>
                    <xsl:for-each select="studentlist/student">
                        <tr>
                            <td>
                                <xsl:value-of select="id"/>
                            </td>
                            <td>
                                <xsl:value-of select="regno"/>
                            </td>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="avg"/>
                            </td>
                            <td>
                                <xsl:value-of select="dob"/>
                            </td>
                            <td>
                                <xsl:value-of select="mobileno"/>
                            </td>
                            <td>
                                <xsl:value-of select="distinction"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
/*
 * Copyright (C) 2017 h0MER247
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Hardware.CPU.Intel8086.Instructions.Logical;

import Hardware.CPU.Intel8086.Intel8086;
import Hardware.CPU.Intel8086.Instructions.Instruction;
import Hardware.CPU.Intel8086.Operands.Operand;


    
public final class TEST16 extends Instruction {

    private final Operand m_destination;
    private final Operand m_source;

    public TEST16(Intel8086 cpu,
                  Operand destination,
                  Operand source,
                  int cycles) {
        
        super(cpu, cycles);

        m_destination = destination;
        m_source = source;
    }

    @Override
    public void run() {
        
        m_cpu.FLAGS.setSZP_16(m_destination.getValue() & m_source.getValue());
        m_cpu.FLAGS.CF = false;
        m_cpu.FLAGS.OF = false;
        m_cpu.FLAGS.AF = false;
        
        m_cpu.updateClock(getCycles());
    }
    
    @Override
    public String toString() {

        return String.format("test %s, %s", m_destination.toString(), m_source.toString());
    }
}
